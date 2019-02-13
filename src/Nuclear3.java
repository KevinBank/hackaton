public class Nuclear3 extends Building
{

    public Nuclear3()
    {
        pollution = 250;
        totalPollution = pollution * buildings;
        production = 7500;
        totalProduction = production * buildings;
        cost = 50000;
        buildings = 0;
    }

}
