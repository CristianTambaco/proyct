package utils;

public enum Strings {

    // ---------------------- Window ----------------------
    WINDOW_TITLE("EduPlan"),


    // ---------------------- Sign Up ----------------------
    EMAIL ("Email"),
    USER ("User"),
    PASSWORD ("Password"),
    PASSWORD_LENGTH ("La contraseña es muy corta"),
    SECURITY_QUESTION ("Security Question"),
    SECURITY_ANSWER ("Security Answer"),
    SAVE_SUCCESS ("Saved Successfully!"),
    ACCOUNT_CREATED ("Cuenta Creada Correctamente"),


    // ---------------------- Login ----------------------
    CAPTCHA_ERROR ("El captcha no coincide"),
    CAPTCHA_EMPTY ("Ingresa el captcha"),
    LOGIN_SUCCESSFULLY ("Inicio de sesión exitoso"),


    // ---------------------- Validation ----------------------
    EMAIL_REQUIRED ("Ingresa tu correo electrónico"),
    USER_REQUIRED ("Ingresa un nombre de usuario"),
    PASSWORD_REQUIRED ("Ingresa una contraseña"),
    PASSWORD_MISMATCH ("Las contraseñas no coinciden"),
    ANSWER_REQUIRED ("Ingresa tu respuesta secreta"),
    EMAIL_SYNTAX ("Email Inválido"),


    // ---------------------- Security Question ----------------------
    FIRST_TEACHER ("¿Cuál es el nombre de tu primer maestro o maestra?"),
    FIRST_PET ("¿Cómo se llamaba tu primer mascota?"),
    BIRTH_CITY ("¿En qué ciudad naciste?"),
    BIRTH_MONTH ("¿En qué mes naciste?"),
    FAVORITE_BOOK ("¿Cuál es el nombre de tu libro favorito?"),
    QUESTION_PROMPT ("Selecciona una pregunta..."),

    USER_LENGTH ("Nombre de usuario muy corto..."),
    ANSWER_LENGTH ("Respuesta muy corta..."),


    // ---------------------- Connection ----------------------
    FIRESTORE_CONNECTED ("Connected to Firestore!"),
    KEY_FILE_ERROR ("Key file not found. Please make sure to provide the correct path."),


    // ---------------------- Provider ----------------------
    ERROR_WRITING ("Error writing document: "),
    UPDATE_SUCCESS ("Updated Successfully!"),
    DELETE_SUCCESS ("Deleted Successfully!"),


    // ---------------------- Errors ----------------------
    IMAGE_404 ("Image not found at "),
    IMAGE_LOAD ("Error loading image: "),
    FXML_404 ("Error: FXML file not found at "),
    RESOURCE_404 ("Resource not found at: "),
    E_LOGGER ("Error during application startup!"),
    ERROR ("ERROR:"),
    EMPTY ("");

    private final String text;
    Strings(String text) { this.text = text; }
    public String getText() { return text; }
}