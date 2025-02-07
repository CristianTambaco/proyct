package model.Captcha;

import model.Loaders.ImageLoader;
import utils.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaptchaValidation {

    // Lista inmutable de captcha
    private final List<Captcha> captchaList;

    public CaptchaValidation() {
        // Inicialización de captchas en un bloque try-catch
        List<Captcha> tempCaptchas = new ArrayList<>();
        try {
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C01.getPath()), "JA3V8"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C02.getPath()), "W93BX"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C03.getPath()), "HJ9PV"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C04.getPath()), "RBSKW"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C05.getPath()), "TSMS9"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C06.getPath()), "459CT"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C07.getPath()), "R84CH"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C08.getPath()), "D4TSH"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C09.getPath()), "3M56R"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C10.getPath()), "HAPK3"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C11.getPath()), "UXP4D"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C12.getPath()), "6H3T8"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C13.getPath()), "PADTC"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C14.getPath()), "YU4RT"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C15.getPath()), "3JYP4"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C16.getPath()), "HWJRC"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C17.getPath()), "X8B9A"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C18.getPath()), "JN6TS"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C19.getPath()), "TK58P"));
            tempCaptchas.add(new Captcha(ImageLoader.loadImage(Paths.C20.getPath()), "XRVSH"));

        } catch (Exception e) { System.err.println("Error al cargar los captchas: " + e.getMessage()); }

        captchaList = List.copyOf(tempCaptchas); // Crear una lista inmutable
    }

    /**
     * Method para obtener un captcha aleatorio.
     * @return Un objeto Captcha con la imagen y la respuesta.
     */
    public Captcha getRandomCaptcha() {
        if (captchaList.isEmpty()) throw new IllegalStateException("No hay captchas disponibles.");
        Random random = new Random();
        return captchaList.get(random.nextInt(captchaList.size()));
    }
}