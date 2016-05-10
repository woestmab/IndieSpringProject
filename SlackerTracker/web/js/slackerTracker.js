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

        backButton.onclick = calendar;

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
        })

    });
})
(jQuery);