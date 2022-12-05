package co.com.tevolvers.certification.tasks;

import co.com.tevolvers.certification.models.Token;
import com.google.gson.Gson;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;


import static co.com.tevolvers.certification.utils.Contantes.AUTH;

public class ObtenerToken implements Task {
    private String userName;
    private String password;
    Gson gson = new Gson();

    public ObtenerToken(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(AUTH).with(
                        requestSpecification -> requestSpecification
                                .header("Content-Type", "application/json")
                                .body("{\"username\" :" + "\"" + userName + "\"," +
                                        "\"password\" :" + "\"" + password + "\"" +
                                        "}")
                                .relaxedHTTPSValidation()

                )

        );

        String json = SerenityRest.lastResponse().asString();
        Token token = gson.fromJson(json, Token.class);
        actor.remember("token", token.getToken());
    }

    public static ObtenerToken token(String user, String password) {
        return Tasks.instrumented(ObtenerToken.class, user, password);
    }
}
