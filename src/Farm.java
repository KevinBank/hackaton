public class Farm extends Building
{
    public Farm()
    {
        pollution = -50;
        totalPollution = (this.pollution * this.buildings);
        production = 25;
        totalProduction = (this.production * this.buildings);
        cost = 150;

    }
}
