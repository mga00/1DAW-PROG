package com.luisantolin.daw.prog.calculadoracidr;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.luisantolin.daw.prog.calculadoracidr")
@IncludeTags({"LOOP","IF","LIM","ERR"})
public class TaggedTests {
}
