/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2018 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.progress;

import lombok.NonNull;

import java.io.PrintStream;


public class PrintStreamLineProgressReporter extends IndexedProgressReporter {
    @NonNull
    private final PrintStream outputStream;
    @NonNull
    private final Integer maxItemsPerLineCount;
    @NonNull
    private final String progressItem;

    public PrintStreamLineProgressReporter(IndexedProgress progress, PrintStream outputStream, int maxItemsPerLineCount, String progressItem) {
        super(progress);

        this.outputStream = outputStream;
        this.maxItemsPerLineCount = maxItemsPerLineCount;
        this.progressItem = progressItem;
    }

    @Override
    public void reportProgress() {
        outputStream.print(progressItem);

        if (operationProgress.getCurrentIndicesCount() % maxItemsPerLineCount == 0) {
            outputStream.println();
        }

        outputStream.flush();
    }
}
