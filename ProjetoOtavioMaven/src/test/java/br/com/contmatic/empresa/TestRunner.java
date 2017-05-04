package br.com.contmatic.empresa;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BairroTest.class, CidadeTest.class, EmpresaTest.class, EnderecoTest.class, EstadoTest.class,
                                                OperadoraTest.class, TelefoneTest.class);

        for(Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

}
