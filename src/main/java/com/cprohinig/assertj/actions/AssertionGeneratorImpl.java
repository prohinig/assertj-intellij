package com.cprohinig.assertj.actions;

import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiMethod;

import java.util.List;

public class AssertionGeneratorImpl implements AssertionGenerator {
    private AssertionDetailsGenerator assertionDetailsGenerator;

    public AssertionGeneratorImpl(AssertionDetailsGenerator assertionDetailsGenerator) {
        this.assertionDetailsGenerator = assertionDetailsGenerator;
    }

    @Override
    public String generateFilename(PsiJavaFile javaFile) {
        return javaFile.getClasses()[0].getName() + "Assert.java";
    }

    @Override
    public String generateContent(PsiJavaFile javaFile, List<PsiMethod> selections) {
        return assertionDetailsGenerator.generateAssertClass(javaFile, selections).getContent();
    }
}
