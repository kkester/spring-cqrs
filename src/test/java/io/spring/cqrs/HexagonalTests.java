package io.spring.cqrs;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.jmolecules.archunit.JMoleculesArchitectureRules;

@AnalyzeClasses(packages = "io.spring.cqrs")
class HexagonalTests {

    @ArchTest
    static ArchRule hexagonal = JMoleculesArchitectureRules.ensureHexagonal();

}
