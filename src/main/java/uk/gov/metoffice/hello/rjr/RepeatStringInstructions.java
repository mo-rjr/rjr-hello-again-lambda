package uk.gov.metoffice.hello.rjr;

import java.util.Objects;

public class RepeatStringInstructions {

    private Integer times;

    private String repeatable;

    public RepeatStringInstructions() {
    }

    public RepeatStringInstructions(Integer times, String repeatable) {
        this.times = times;
        this.repeatable = repeatable;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public void setRepeatable(String repeatable) {
        this.repeatable = repeatable;
    }

    public Integer getTimes() {
        return times;
    }

    public String getRepeatable() {
        return repeatable;
    }

    @Override
    public String toString() {
        return "RepeatStringInstructions{" +
                "times=" + times +
                ", repeatable='" + repeatable + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepeatStringInstructions that = (RepeatStringInstructions) o;
        return Objects.equals(times, that.times) &&
                Objects.equals(repeatable, that.repeatable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(times, repeatable);
    }
}
