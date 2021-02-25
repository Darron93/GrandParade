import apiObjects.DataList;
import apiObjects.GenerationMix;
import apiObjects.Intensity;
import apiObjects.Regions;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class ApiAutomationTest1 {

    private List<Regions> regions = new ArrayList<>();

    @BeforeMethod
    public void preconditions() {

        //get list of regions with other details
        regions =
                given().
//                  log().all().    //uncomment if you want to see all logs
                    when().
                    get("https://api.carbonintensity.org.uk/regional/").
                    then().
//                  log().all().    //uncomment if you want to see all logs
                    statusCode(200)
                    .extract().as(DataList.class) //DataList wiaze sie z klasami pomocniczymi z paczki: apiObjects
                    .getData().get(0).getRegions();
    }

    @Test
    public void scenario1() {

        System.out.println("------------------------------");
        System.out.println("SCENARIO 1:");

        //get regionID list
        List<Long> regionIds = regions.stream().map(Regions::getRegionid).collect(Collectors.toList());

        //get intensity value forecast
        List<Integer> forecastValues = regions.stream().map(Regions::getIntensity).map(Intensity::getForecast).collect(Collectors.toList());

        //get shortnames list
        List<String> shortNames = regions.stream().map(Regions::getShortname).collect(Collectors.toList());

        //make hashMap with sorting forcast in reverese order and display with shortnames
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<forecastValues.size();i++){
            map.put(shortNames.get(i),forecastValues.get(i));
        }
        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(System.out::println);

        System.out.println("------------------------------");
    }

    @Test
    public void scenario2() {

        System.out.println("------------------------------");
        System.out.println("SCENARIO 2:");

        //get generationmix values
        List<List<GenerationMix>> fuelList = regions.stream().map(Regions::getGenerationmix).collect(Collectors.toList());
        List<Long> regionIds = regions.stream().map(Regions::getRegionid).collect(Collectors.toList());

        //expected value
        Double expectedValue = 100.0;

        //display sum of perc field for each region with assertion of value 100.0
        for (int i = 0; i<regionIds.size(); i++) {
            try {
                Double sum = fuelList.get(i).stream().mapToDouble(GenerationMix::getPerc).sum();
                Long regionId = regionIds.get(i);
                Assert.assertEquals(sum, expectedValue);
                System.out.println("Region ID "  + regionId + ": Sum: " + sum + ", Expected sum: " + expectedValue + " - PASSED");
            }catch (AssertionError ar) {
                Double sum = fuelList.get(i).stream().mapToDouble(GenerationMix::getPerc).sum();
                Long regionId = regionIds.get(i);
                System.out.println("Region ID "  + regionId + ": Sum: " + sum + ", Expected sum: " + expectedValue + " - FAILED");
            }
        }

        System.out.println("------------------------------");
    }


    //Scenario 3:
//
//        List<Double> fuelBiomass = fuelList.stream().flatMap(Collection::stream).filter(a -> Objects.equals(a.getFuel(), "biomass"))
//                .map(a -> a.getPerc())
//                .collect(Collectors.toList());
//
//        System.out.println(fuelBiomass);
//

//
// -----------------------------------------------------
}
