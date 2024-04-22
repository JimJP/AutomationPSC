package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PeiAccEstPage;
import pageObjects.PeiObjEstPage;

public class PeiPscSteps {
    PeiObjEstPage peiObjEstPage = new PeiObjEstPage();
    PeiAccEstPage peiAccEstPage = new PeiAccEstPage();
    //NUEVO REGISTRO OBJETIVO ESTRATEGICO

    @And("Ingreso al menú de Objetivos Estrategicos")
    public void ingresarMenuObjetivosEstrategicos(){
        peiObjEstPage.ingresarMenuObjetivosEstrategicos();
    }
    @And("Selecciono Nuevo registro")
    public void seleccionarNuevoRegistroObjEst(){
        peiObjEstPage.seleccionarNuevoRegistroObjEst();
    }

    @When("Completo el formulario de Objetivos Estrategicos {string}, {string}, {string}")
    public void completarFormularioObjEst(String enunciado, String descripcion, String explicacion) {
        peiObjEstPage.completarFormularioObjEst(enunciado, descripcion, explicacion);
    }

    @Then("Se muestra mensaje de registro exitoso")
    public void validarRegistroExitoso(){
        peiObjEstPage.validarRegistroExitoso();
    }

    //EDITAR REGISTRO OBJETIVO ESTRATEGICO
    @And("Ubicar registro y presionar icono Editar")
    public void seleccionarRegistroGrillaObjEst() throws InterruptedException {
        peiObjEstPage.utbicarRegistroGrillaEditar();
    }


    @When("Edito el formulario de Objetivos Estrategicos {string}, {string}, {string}, {string}, {string}")
    public void editarFormularioObjEst(String codigo, String enunciado, String descripcion, String explicacion, String accionesEst){
        peiObjEstPage.editarFormularioObjEst(codigo, enunciado, descripcion, explicacion, accionesEst);
    }

    @Then("Se muestra mensaje de edicion exitosa")
    public void validarEdicionExitosa(){
        peiObjEstPage.validarEdicionExitosa();
    }

    //ELIMINAR REGISTRO OBJETIVO ESTRATEGICO
    @And("Ubicar registro y presionar icono Eliminar")
    public void ubicarRegistroGrillaEliminar() throws InterruptedException {
        peiObjEstPage.ubicarRegistroGrillaEliminar();
    }

    @And("Confirmo la eliminacion presionando SI")
    public void confirmarMensajeEliminacion (){
        peiObjEstPage.confirmarMensajeEliminacion();
    }

    @Then("Se muestra mensaje de eliminacion exitosa")
    public void validarEliminacionExitosa () {
        peiObjEstPage.validarEliminacionExitosa();

    }

    //NUEVO REGISTRO ACCIONES ESTRATEGICAS
    @And("Ingresar Menu Acciones Estrategicas")
    public void ingresarMenuAccionesEstrategicas(){
        peiAccEstPage.ingresarMenuAccionesEstrategicas();
    }
    @And("Seleccionar Nueva Accion Estrategica")
    public void seleccionarNuevaAccionEstrategica(){
        peiAccEstPage.seleccionarNuevaAccionEstrategica();
    }

    @When("Completar formulario de Acciones Estrategicas {string}, {string}, {string}")
    public void completarFormularioAccionesEstrategicas(String enunciado, String descripcion, String explicacion) {
        peiAccEstPage.completarFormularioAccionesEstrategicas();
    }

    @Then("Muestra mensaje Accion Estrategica creada")
    public void mostrarMensajeAccionEstrategicaCreada(){
        peiAccEstPage.mostrarMensajeAccionEstrategicaCreada();
    }

}
