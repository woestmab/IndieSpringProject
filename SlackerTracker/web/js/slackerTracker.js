/**
 * Created by Bdub on 5/9/16.
 */

(function ($)
{
    $(document).ready(function ()
    {
        calendar();

        var backButton = $('#backButton');
        var calTab = $('#cal-tab');
        var routeTab = $('#route-tab');
        var routeBtn = $('#route-btn');

        backButton.click(calendar);

        function calendar()
        {
            var calendar = $("#calendar").calendar(
                {
                    tmpl_path: "tmpls/",
                    events_source: "/get-appts"
                });
        }

        calTab.click(function ()
        {
            $('#cal-div').show();
            $('#route-div').hide();
        });

        routeTab.click(function ()
        {
            $('#route-div').show();
            $('#cal-div').hide();
        });

        routeBtn.click(function ()
        {
            var url = "/get-appts";
            var date = $('#route-date-input').val();

            url += "?date=" + date;

            $.get(url, function (data)
            {
                var json = $.parseJSON(data);
                var trips = [];
                var rides = [];

                json.forEach(function (e)
                {
                    trips.push(e);
                });

                trips.forEach(function (e)
                {
                    rides.push(e[0]);
                });
            });
        });

    });
})
(jQuery);