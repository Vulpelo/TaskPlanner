package sample.Drools;

import org.apache.commons.lang.builder.CompareToBuilder;

import java.util.Comparator;

public class TaskDifficultyComparator implements Comparator<Task> {
        public int compare(Task a, Task b) {
            return new CompareToBuilder()
                    .append(a.getRequiredMultiplicand(), b.getRequiredMultiplicand())
                    .append(a.getId(), b.getId())
                    .toComparison();
        }
}
