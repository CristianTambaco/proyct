package exceptions;


public class FirebaseExceptions extends Exception {

  public FirebaseExceptions(String message) {
    super(message);
  }

  // Method personalizado para obtener un mensaje más claro según el código de error de Firebase
  public String getCustomMessage() {
    String errorMessage = super.getMessage();

    if (errorMessage.contains("INVALID_EMAIL")) {
      return "El correo ingresado no es válido.";
    } else if (errorMessage.contains("WRONG_PASSWORD")) {
      return "La contraseña es incorrecta.";
    } else if (errorMessage.contains("USER_NOT_FOUND")) return "El usuario no existe. Verifica tu correo.";
    else return "Ocurrió un error inesperado en Firebase.";

  }
}
