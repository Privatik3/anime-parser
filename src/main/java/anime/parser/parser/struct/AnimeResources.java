package anime.parser.parser.struct;

import anime.parser.parser.enums.ResoursesName;

public class AnimeResources {

    ResoursesName name;
    String url;

    public ResoursesName getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setName(ResoursesName name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
