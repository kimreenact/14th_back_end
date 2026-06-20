public class LionPolicy implements PolicyIF {

    @Override
    public String submitCheck() {
        return "✅ 가능";
    }

    @Override
    public String generationCheck(int generation) {
        return generation >= 14 ? "✅ 충족" : "❌ 미충족";
    }
}