public class Gun {

    public static enum Range{
        CLOSE,
        MID,
        LONG
    }

    public String model;
    public Boolean handy;
    public String origin;
    public String material;
    public Range ttc_range;
    public int ttc_aimed;
    public int ttc_clip;
    public Boolean ttc_scope;

    public Gun(String model, Boolean handy, String origin, String material, Range ttc_range, int ttc_aimed, int ttc_clip, Boolean ttc_scope) {
        this.model = model;
        this.handy = handy;
        this.origin = origin;
        this.material = material;
        this.ttc_range = ttc_range;
        this.ttc_aimed = ttc_aimed;
        this.ttc_clip = ttc_clip;
        this.ttc_scope = ttc_scope;
    }

}
