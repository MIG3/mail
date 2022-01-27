package com.mgubin.mail;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "com.mgubin.mail",
        tags = "@cur"
)

public class RunByTags
{

}
