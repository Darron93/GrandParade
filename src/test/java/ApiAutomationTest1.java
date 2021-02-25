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

        List<Regions> regions =
                given().
                        log().all().
                        when().
                        get("https://api.carbonintensity.org.uk/regional/").
                        then().
                        log().all().
                        statusCode(200)
                        .extract().as(DataList.class)
                        .getData().get(0).getRegions();

//        System.out.println(regions);

        List<Long> regionIds = regions.stream().map(Regions::getRegionid).collect(Collectors.toList());
        System.out.println(regionIds);

        //sortowanie od najwyzszej forecastValues do najnizszej
        List<Integer> forecastValues = regions.stream().map(Regions::getIntensity).map(Intensity::getForecast).collect(Collectors.toList());
        System.out.println(forecastValues);
        Collections.sort(forecastValues, Collections.reverseOrder());
        System.out.println(forecastValues);

        //
        List<String> shortNames = regions.stream().map(Regions::getShortname).collect(Collectors.toList());
        System.out.println(shortNames);

//
        //sumowanie ------------------

        List<List<GenerationMix>> fuelList = regions.stream().map(Regions::getGenerationmix).collect(Collectors.toList());
        Double expectedValue = 100.0;
        for (int i = 0; i<18; i++) {
            Double sum = fuelList.get(i).stream().mapToDouble(GenerationMix::getPerc).sum();
            System.out.println(sum);
            Assert.assertEquals(sum, expectedValue);
        }


        //System.out.println(fuelList);


        //trzecie ---------------------
//
//        List<Double> fuelBiomass = fuelList.stream().flatMap(Collection::stream).filter(a -> Objects.equals(a.getFuel(), "biomass"))
//                .map(a -> a.getPerc())
//                .collect(Collectors.toList());
//
//        System.out.println(fuelBiomass);
//

//
//





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
