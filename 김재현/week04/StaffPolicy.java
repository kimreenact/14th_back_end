public class StaffPolicy implements PolicyIF {

    @Override
    public String submitCheck() {
        return "❌ 불가능";
    }

    @Override
    public String generationCheck(int generation) {
        return generation >= 14 ? "✅ 충족" : "❌ 미충족";
    }
}