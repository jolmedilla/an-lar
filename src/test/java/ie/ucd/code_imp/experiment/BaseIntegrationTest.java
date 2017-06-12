/**
 * Copyright 2017 Juan Olmedilla Arregui
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ie.ucd.code_imp.experiment;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;

import ie.ucd.code_imp.Optimiser;

/**
 * @author Juan Olmedilla Arregui
 *
 */
public class BaseIntegrationTest {

    protected List<String> arguments = new ArrayList<String>();
    
    @Parameter
    public String algorithm;
    
    @Parameter(1)
    public int run;
    
    protected volatile Throwable uncaughtException;

    BaseIntegrationTest() {
        arguments.addAll(Arrays.asList(new String[] { "-r",
                "MoveClassLayer,MoveMethodLayerNoDelegation,MoveFieldLayer,MoveStaticFieldLayer",
                "-g", "ILCOF,ILCOF_F,ILCOF_M", "-y",
                "3:org.apache.tools.ant.taskdefs", "-y", "2:org.apache.tools.ant",
                "-y", "1:org.apache.tools.bzip2", "-y", "1:org.apache.tools.mail",
                "-y", "1:org.apache.tools.tar", "-y", "1:org.apache.tools.zip",
                "-i", "target/apache-ant/src", "-l", "target/apache-ant/lib", "-a",
                "30" }));
        
    }

    protected void extraArguments() {
        arguments.add("-o");
        arguments.add("target/apache-ant/results/" + algorithm + "/run-" + run);
        arguments.add(algorithm);
    }

    @Test
    public void testAlgorithm() throws Throwable {
        extraArguments();
        Thread.setDefaultUncaughtExceptionHandler(
                new UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        uncaughtException = e;
    
                    }
                });
    
        Optimiser.main(arguments.toArray(new String[arguments.size()]));
        if (uncaughtException != null) {
            throw uncaughtException;
        }
    }

}
