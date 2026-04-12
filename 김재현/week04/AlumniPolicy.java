public class AlumniPolicy implements PolicyIF {

    private final int generation;

    public AlumniPolicy(int generation) {
        this.generation = generation;
    }

    @Override
    public String submitCheck() {
        return generation >= 14 ? "✅ 가능" : "❌ 불가능";
    }

    @Override
    public String generationCheck(int generation) {
        return generation >= 14 ? "✅ 충족" : "❌ 미충족";
    }
}