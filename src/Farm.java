public class Farm extends Building
{
    public Farm()
    {
        pollution = -50;
        totalPollution = pollution * buildings;
        production = 25;
        totalProduction = production * buildings;
        cost = 150;

    }
}
