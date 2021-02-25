import apiObjects.DataList;
import apiObjects.GenerationMix;
import apiObjects.Intensity;
import apiObjects.Regions;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class ApiAutomationTest1 {

    @SneakyThrows
    @Test
    public void apiAutomationTest1() {

        //pobranie za pomoca metod rest assured regionow wraz ze szczegolami
        List<Regions> regions =
                given().
                    log().all().
                    when().
                    get("https://api.carbonintensity.org.uk/regional/").
                    then().
                    log().all().
                    statusCode(200)
                    .extract().as(DataList.class) //DataList wiaze sie z klasami pomocniczymi z paczki: apiObjects
                    .getData().get(0).getRegions();


        //SCENARIUSZE TESTOWE:

        System.out.println("------------------------------");
        System.out.println("SCENARIO 1:");

        //pobranie oraz wyswietlenie listy shortnames
        List<Long> regionIds = regions.stream().map(Regions::getRegionid).collect(Collectors.toList());
        System.out.println(regionIds);

        //pobranie oraz wyswietlenie listy forecastValues
        List<Integer> forecastValues = regions.stream().map(Regions::getIntensity).map(Intensity::getForecast).collect(Collectors.toList());
        System.out.println(forecastValues);

        //sortowanie listy od najwiekszej wartosci do najmniejszej oraz wyswietlenie
        Collections.sort(forecastValues, Collections.reverseOrder());
        System.out.println(forecastValues);

        //pobranie oraz wyswietlenie listy shortnames
        List<String> shortNames = regions.stream().map(Regions::getShortname).collect(Collectors.toList());
//        List<String> shortNames2 = forecastValues.stream().map()
        System.out.println("Shortnames: " + shortNames.get(2) + ", forecast: " + forecastValues.get(2));


        System.out.println("------------------------------");
        System.out.println("SCENARIO 2:");

        //pobranie oraz wyswietlenie zagniezdzonej listy fuellist
        List<List<GenerationMix>> fuelList = regions.stream().map(Regions::getGenerationmix).collect(Collectors.toList());

        //oczekiwana wartosc
        Double expectedValue = 100.0;

        //wyswietlanie sumy pola perc dla kazdego regionu wraz z asercja wartosci
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


        //System.out.println(fuelList);


        //Scenario 3: ---------------------
//
//        List<Double> fuelBiomass = fuelList.stream().flatMap(Collection::stream).filter(a -> Objects.equals(a.getFuel(), "biomass"))
//                .map(a -> a.getPerc())
//                .collect(Collectors.toList());
//
//        System.out.println(fuelBiomass);
//

//
// -----------------------------------------------------

//    List<Integer> regionIds =
//            given().
//                log().all().
//                when().
//                get("https://api.carbonintensity.org.uk/regional/").
//                then().
//                log().all().
//                statusCode(200).
//                extract().as(DataList.class).
//            getData().get(0).getRegions().stream().map(Regions::getIntensity).map(Intensity::getForecast).collect(Collectors.toList());
//
//    System.out.println(regionIds);


//    System.out.println(regionIds);


//        String data = given().
//                log().all().
//                when().
//                get("https://api.carbonintensity.org.uk/regional/").
//                then().
//                log().all().
//                statusCode(200).
//                extract().
//                response().
//                path("intensity");

        //Response response = get("https://carbon-intensity.github.io/api-definitions/#getregional-regionid-regionid");
//        Response request = get("https://api.carbonintensity.org.uk/regional/");

//        String elemement = given().
//                contentType("application/json").
//                body("intensity").
//                when().
//                get("https://api.carbonintensity.org.uk/regional/").
//                then().
//                statusCode(200).
//                extract().asString();


//        System.out.println(request.getBody().asString());
//        String data = get("/intensity").path("forecast");
//        System.out.println(path("intensity").toString(););
    }
}
