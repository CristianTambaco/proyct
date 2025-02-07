package utils;

public enum Paths {

    KEY ("src/main/resources/key_fx.json"),
    WINDOW_ICON ("/images/icon_window.png"),
    LAUNCHER ("/views/signView.fxml"),
    LOGIN_VIEW ("/views/loginView.fxml"),
    SIGN_VIEW ("/views/signView.fxml"),
    QUESTION_VIEW ("/views/questionView.fxml"),
    MAIN_VIEW ("/views/mainView.fxml"),
    CHANGE_VIEW ("/views/changeView.fxml"),
    LIGHT_THEME ("/css/light.css"),
    DARK_THEME ("/css/dark.css"),

    // Captcha
    C01 ("/images/captcha/01.jpg"),
    C02 ("/images/captcha/02.jpg"),
    C03 ("/images/captcha/03.jpg"),
    C04 ("/images/captcha/04.jpg"),
    C05 ("/images/captcha/05.jpg"),
    C06 ("/images/captcha/06.jpg"),
    C07 ("/images/captcha/07.jpg"),
    C08 ("/images/captcha/08.jpg"),
    C09 ("/images/captcha/09.jpg"),
    C10 ("/images/captcha/10.jpg"),
    C11 ("/images/captcha/11.jpg"),
    C12 ("/images/captcha/12.jpg"),
    C13 ("/images/captcha/13.jpg"),
    C14 ("/images/captcha/14.jpg"),
    C15 ("/images/captcha/15.jpg"),
    C16 ("/images/captcha/16.jpg"),
    C17 ("/images/captcha/17.jpg"),
    C18 ("/images/captcha/18.jpg"),
    C19 ("/images/captcha/19.jpg"),
    C20 ("/images/captcha/20.jpg");


    private final String path;
    Paths(String path) { this.path = path; }
    public String getPath() { return path; }
}