package lantar.spy.api;

/**
 * Created by Lantar on 21.08.2015.
 */

public enum HandlerResult {
    SERVEREROR(-80), ERROR(0), WRONG_EMAIL(-1), EMAIL_EXISTS(-2), OK(1), ACCESS_DENIED(2), PHOTO_DOWNLOAD_COMPLITE(3), USER_CREATE(
            4), SERVER_OK(11), GET_OBJECT(13), REPORT_TAKE(14), ROUTS_TAKE(101);

    private int result;

    private HandlerResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public static HandlerResult valueOf(int value) {
        for (HandlerResult result : HandlerResult.values()) {
            if (value == result.getResult()) {
                return result;
            }
        }
        throw new IllegalArgumentException("No enum const " + value);
    }
}