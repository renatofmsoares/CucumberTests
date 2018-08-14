package br.com.rfms.runners;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/features/inserir_conta.feature",
	glue = "br.com.rfms.steps",
	tags = {"~@ignore"},
	plugin = "pretty",
	monochrome = true,
	snippets = SnippetType.CAMELCASE,
	dryRun = false,
	strict = true)
public class RunnerTest {
}
