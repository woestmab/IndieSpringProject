/**
 * Created by Bdub on 2/26/16.
 */

function init()
{

    calendar();

    var backButton = document.getElementById('backButton');
    backButton.onclick = calendar;

    function calendar() {
        var calendar = $("#calendar").calendar(
            {
                tmpl_path: "../tmpls",
                events_source: function () {
                    return [
                        {
                            "id": 1,
                            "title": "Enterprise Java",
                            "url": "https://github.com/MadJavaEntSpring2016/Home",
                            "class": "event-success",
                            "start": 1455215400000, // Milliseconds
                            "end": 1455222000000 // Milliseconds
                        },
                        {
                            "id": 2,
                            "title": "PHP",
                            "url": "http://flibbertigiblets.com/phpWebDevMySQL/",
                            "class": "event-info",
                            "start": 1455222600000, // Milliseconds
                            "end": 1455229200000 // Milliseconds
                        }
                    ];
                }
            });
    }
}