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

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * @author Juan Olmedilla Arregui
 *
 */
@RunWith(Parameterized.class)
public class SequentialIntegrationTest extends AbstractIntegrationTestBase {

    @SuppressWarnings("unchecked")
    @Parameters(name = "algorithm=\"{0}\", run=\"{1}\"")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { "ga", 1 }, { "ga", 2 }, { "ga", 3 } });
    }

    @Test
    public void test() throws Throwable {
        super.testAlgorithm();
    }
}
