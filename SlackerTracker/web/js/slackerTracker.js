/**
 * Created by Bdub on 5/9/16.
 */

(function ($)
{

    $(document).ajaxStart(function ()
    {
        $("#wait").css("display", "block");
    });

    $(document).ajaxComplete(function(){
        $("#wait").css("display", "none");
    });

    $(document).ready(function ()
    {
        calendar();

        var backButton = $('#backButton');
        var calTab = $('#cal-tab');
        var routeTab = $('#route-tab');
        var editTab = $('#edit-tab');
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
            $('#cal-li').addClass("active");
            $('#route-li').removeClass("active");
            $('#edit-li').removeClass("active");
            calendar();
        });

        routeTab.click(function ()
        {
            $('#route-div').show();
            $('#cal-div').hide();
            $('#edit-div').hide();
            $('#route-li').addClass("active");
            $('#cal-li').removeClass("active");
            $('#edit-li').removeClass("active");
        });

        editTab.click(function ()
        {
            $('#edit-div').show();
            $('#route-div').hide();
            $('#cal-div').hide();
            $('#edit-li').addClass("active");
            $('#route-li').removeClass("active");
            $('#cal-li').removeClass("active");

            var url = '/get-appts';
            var date = null;

            $.get(url, date, function (data)
            {
                refreshEditTable();
                refreshRouteTable();
                addEditTable(data.result);
            });
            
        });

        routeBtn.click(function ()
        {
            var url = "/get-appts";
            var date = $('#route-date-input').val();

            url += "?date=" + date;

            $.get(url, function (data)
            {
                refreshRouteTable();
                refreshEditTable();
                addRouteTable(data);
            });
        });

        $('body').on('click', 'table > tbody > tr', function (e)
        {
            console.log(this.id);
        });

    });
})
(jQuery);

function addRouteTable(data)
{
    var json = $.parseJSON(data);

    var trips = [];
    var table = $('<table id="result-table" class="table table-bordered">');
    var thead = $('<thead><tr><th>Bus Number</th><th>Departure Time</th><th>Departure Stop</th>" + ' +
        '"<th>Stop Location</th><th>Arrival Time</th><th>Arrival Stop</th></tr></thead>');
    var tbody = $('<tbody>');

    $('#route-results-div').append(table);
    $('#result-table').append(thead);
    $('#result-table').append(tbody);

    json.forEach(function (e)
    {
        trips.push(e);
    });

    trips.forEach(function (t)
    {
        t.forEach(function (r)
        {
            $('#result-table tbody').append('<tr><td>'+ r["bus-number"] + '</td><td>' +
                r["departure-time"] + '</td><td>'+ r["departure-stop"] + '</td><td>'+
                r["stop-location"] + '</td><td>'+ r["arrival-time"] + '</td><td>'+
                r["arrival-stop"] + '</td></tr>');
            console.log(r);
        });
    });
}

function addEditTable(data)
{
    var table = $('<table id="edit-table" class="table table-bordered table-striped table-hover">');
    var thead = $('<thead><tr><th>Title</th><th>Start</th><th>End</th></tr></thead>');
    var tbody = $('<tbody>');

    $('#edit-div').append(table);
    $('#edit-table').append(thead);
    $('#edit-table').append(tbody);

    data.forEach(function (a)
    {
            $('#edit-table tbody').append('<tr id="' + a.id + '"><td>'+ a.title + '</td><td>' +
                a.start + '</td><td>'+ a.end + '</td></tr>');
    });
}

function refreshRouteTable()
{
    $('#result-table').remove();
}

function refreshEditTable()
{
    $('#edit-table').remove();
}