public class Farm extends Building
{
    public Farm()
    {
        pollution = 0;
        totalPollution = pollution * buildings;
        production = 0;
        totalProduction = production * buildings;
    }
}
