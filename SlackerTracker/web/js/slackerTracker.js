/**
 * Created by Bdub on 5/9/16.
 */

(function ($)
{
    $(document).ready(function ()
    {
        calendar();

        var backButton = document.getElementById('backButton');
        backButton.onclick = calendar;

        function calendar()
        {
            var calendar = $("#calendar").calendar(
                {
                    tmpl_path: "tmpls/",
                    events_source: "/get-appts"
                });
        }
    });
})
(jQuery);