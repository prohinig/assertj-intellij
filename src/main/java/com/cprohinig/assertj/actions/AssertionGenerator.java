package com.cprohinig.assertj.actions;

import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiMethod;

import java.util.List;

public interface AssertionGenerator {

    String generateFilename(PsiJavaFile javaFile);

    String generateContent(PsiJavaFile javaFile, List<PsiMethod> selections);

}
