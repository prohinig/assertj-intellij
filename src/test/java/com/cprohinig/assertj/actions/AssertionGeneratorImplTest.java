package com.cprohinig.assertj.actions;

import com.cprohinig.assertj.testutils.TestUtils;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiMethod;
import com.intellij.testFramework.LightPlatformCodeInsightTestCase;
import org.junit.Assert;

import java.util.List;

public class AssertionGeneratorImplTest extends LightPlatformCodeInsightTestCase {

    AssertionGeneratorImpl target = new AssertionGeneratorImpl(new AssertionDetailsGeneratorImpl());

    public void testGenerateContent() throws Exception {
        // given
        setupJavaFile("SimpleClass.java");
        PsiJavaFile currentFile = (PsiJavaFile) getFile();
        List<PsiMethod> psiMethods = AssertionDetailsGeneratorImpl.extractGetters(currentFile);

        // when
        String content = target.generateContent(currentFile, psiMethods);

        // then
        assertContentAreEquals(content, "SimpleClassAssert.java");
    }

    private void assertContentAreEquals(String actualContent, String expectedContentFile) throws Exception {
        String fileContent = TestUtils.getFileContent(expectedContentFile);
        Assert.assertEquals(actualContent.replaceAll("\\s+",""), fileContent.replaceAll("\\s+",""));
    }

    private void setupJavaFile(String fileName) throws Exception {
        String fileContent = TestUtils.getFileContent(fileName);
        configureFromFileText(fileName, fileContent);
    }
}