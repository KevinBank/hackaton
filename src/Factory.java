public class Factory extends Building
{

    public Factory()
    {
        pollution = 1000;
        totalPollution = pollution * buildings;
        production = 500;
        totalProduction = production * buildings;
        cost = 250;
        buildings = 0;
    }

}
