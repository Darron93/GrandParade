package apiObjects;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Regions {

    private Long regionid;
    private String dnoregion;
    private String shortname;
    private Intensity intensity;
    private List<GenerationMix> generationmix = new ArrayList<>();
}
