package apiObjects;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MainData {

    private String from;
    private String to;
    private List<Regions> regions = new ArrayList<>();
}
