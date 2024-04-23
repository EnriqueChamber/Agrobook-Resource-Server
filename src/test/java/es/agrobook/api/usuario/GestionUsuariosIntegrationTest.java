package es.agrobook.api.usuario;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = {"src/test/resources/features/usuario/gestion_usuarios.feature"}
  , plugin = {"pretty", "html:target/reports/usuario/gestion_usuarios.html"}
)
public class GestionUsuariosIntegrationTest {

}