package es.agrobook.api.usuario;

import io.cucumber.java.en.*;

public class GestionUsuariosRunSteps {

    //#region Given Steps
    @Given("un usuario que inicio sesion con el nombre de usuario {string}")
    public void un_usuario_que_inicio_sesion_con_el_nombre_de_usuario(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("que un usuario quiere crear una nueva cuenta")
    public void que_un_usuario_quiere_crear_una_nueva_cuenta() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("un usuario administrador con nombre de usuario {string}")
    public void un_usuario_administrador_con_nombre_de_usuario(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("existe un usuario con el nombre de usuario {string}")
    public void existe_un_usuario_con_el_nombre_de_usuario(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("un usuario normal con nombre de usuario {string}")
    public void un_usuario_normal_con_nombre_de_usuario(String s) {
        // Write code here that turns the phrase above into concrete actions
    }
    //#endregion


    //#region When Steps
    @When("el usuario proporciona datos de registro validos")
    public void el_usuario_proporciona_datos_de_registro_validos() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("el usuario actualiza su propia informacion con nuevos detalles")
    public void el_usuario_actualiza_su_propia_informacion_con_nuevos_detalles() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("el usuario solicita su propia informacion de usuario")
    public void el_usuario_solicita_su_propia_informacion_de_usuario() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("el usuario administrador actualiza la informacion del usuario {string} con nuevos detalles")
    public void el_usuario_administrador_actualiza_la_informacion_del_usuario_con_nuevos_detalles(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("el usuario normal intenta actualizar la informacion del usuario {string}")
    public void el_usuario_normal_intenta_actualizar_la_informacion_del_usuario(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("el usuario solicita la informacion para un usuario no existente")
    public void el_usuario_solicita_la_informacion_para_un_usuario_no_existente() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("el usuario solicita la informacion para el usuario {string}")
    public void el_usuario_solicita_la_informacion_para_el_usuario(String s) {
        // Write code here that turns the phrase above into concrete actions
    }
    //#endregion


    //#region Then Steps
    @Then("el sistema deberia devolver un mensaje indicando que el usuario no existe")
    public void el_sistema_deberia_devolver_un_mensaje_indicando_que_el_usuario_no_existe() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("el sistema deberia crear una nueva cuenta de usuario con los detalles proporcionados.")
    public void el_sistema_deberia_crear_una_nueva_cuenta_de_usuario_con_los_detalles_proporcionados() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("el sistema deberia actualizar la informacion del usuario para {string}")
    public void el_sistema_deberia_actualizar_la_informacion_del_usuario_para(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("el sistema deberia devolver los detalles del usuario para {string}")
    public void el_sistema_deberia_devolver_los_detalles_del_usuario_para(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("el sistema deberia negar la operacion de actualizacion debido a permisos insuficientes.")
    public void el_sistema_deberia_negar_la_operacion_de_actualizacion_debido_a_permisos_insuficientes() {
        // Write code here that turns the phrase above into concrete actions
    }
    //#endregion
}
