window.mb = window.mb or {}
window.mb.chart = window.mb.chart or {}
window.mb.chart.themes = window.mb.chart.themes or {}
window.mb.chart.themes.fontStyle =
  fontSize: "10px"
  color: "#000000"
  fontWeight: "normal"
  fontFamily: "'SourceSansPro-ExtraLight', Arial, sans-serif"

window.mb.chart.themes.common =
  credits:
    enabled: false

  exporting:
    enabled: false

  title:
    style: $.extend({}, window.mb.chart.themes.fontStyle,
      fontSize: "12px"
    )

  labels:
    style: $.extend({}, window.mb.chart.themes.fontStyle,
      fontSize: "20px"
    )

  xAxis:
    title:
      style: $.extend({}, window.mb.chart.themes.fontStyle,
        backgroundColor: "#ffffff"
      )

    labels:
      style: window.mb.chart.themes.fontStyle

    lineColor: "#000000"

  yAxis:
    title:
      style: $.extend({}, window.mb.chart.themes.fontStyle,
        backgroundColor: "#ffffff"
      )

    labels:
      style: window.mb.chart.themes.fontStyle

    lineColor: "#000000"

  chart:
    style:
      fontFamily: window.mb.chart.themes.fontStyle

  plotOptions:
    series:
      marker:
        symbol: "square"

  tooltip:
    headerFormat: "<span style='font-size: 10px'><b>{point.key}</b></span><br/>"
    style: $.extend({}, window.mb.chart.themes.fontStyle)
    valueDecimals: 2

  legend:
    itemStyle: window.mb.chart.themes.fontStyle
    y: 10

window.mb.chart.themes.temporal = window.mb.chart.themes.temporal or {}

window.mb.chart.themes.temporal.common = Highcharts.merge(window.mb.chart.themes.common,
  chart:
    spacingLeft: 0

  title:
    text: null

  xAxis:
    gridLineWidth: 1
    type: "datetime"
    lineColor: "#000000"
    lineWidth: 1
    maxPadding: 0
    minPadding: 0
    showFirstLabel: true
    title:
      margin: 0

  yAxis:
    title: null

    lineColor: "#000000"
    lineWidth: 1

  tooltip:
    crosshairs:
      color: "black"
      dashStyle: "solid"
      lineWidth: 2

    shared: true

  plotOptions:
    series:
      lineWidth: 1
      marker:
        enabled: false

      zIndex: 0
      pointPlacement: "on"
) 