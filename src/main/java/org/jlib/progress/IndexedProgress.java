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

public class IndexedProgress {
    private final Integer firstIndex;
    private final Integer lastIndex;
    private Integer currentIndex;

    public IndexedProgress(int firstIndex, int lastIndex) {
        if (lastIndex < firstIndex)
            throw new IllegalArgumentException(lastIndex + " = lastIndex < firstIndex = " + firstIndex);

        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
        currentIndex = firstIndex;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public int getCurrentIndex() {
        if (currentIndex > lastIndex)
            throw new IllegalStateException(currentIndex + " = currentIndex > lastIndex = " + lastIndex);

        return currentIndex;
    }

    public void increaseCurrentIndex() {
        currentIndex++;
    }

    public int getCurrentIndicesCount() {
        return currentIndex - firstIndex + 1;
    }

    public int getIndicesCount() {
        return lastIndex - firstIndex + 1;
    }
}
