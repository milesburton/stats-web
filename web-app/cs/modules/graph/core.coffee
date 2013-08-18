###
graph jQuery Plugin v1.0

###
jQuery ->
  $.graph = ( element, options ) ->

    # plugin settings
    @settings = {}

    # jQuery version of DOM element attached to the plugin
    @$element = $ element

    @init = ->
      @settings = $.extend( {}, @defaults, options )

      $.ajax {url: @$element.data('chart-source'), success: (chartData, textStatus, jqXHR) => _chartSourceCallback(chartData)}


    _chartSourceCallback = (chartOptions) =>
      chartOptions = _mergeDefaultTheme chartOptions
      chartOptions = _mergeTheme chartOptions
      _renderChart chartOptions

    _mergeOptions = (left, right) =>
      Highcharts.merge(left, right)

    _mergeDefaultTheme = (chartOptions) =>
      _mergeOptions(mb.chart.themes.common, chartOptions)

    _mergeTheme = (chartOptions) =>
      overrideTheme = undefined
      if @$element.data('chart-theme')?
        overrideTheme = eval(@$element.data('chart-theme'))

      chartOptions = _mergeOptions(chartOptions, overrideTheme) if overrideTheme?
      chartOptions

    _renderChart = (options) =>
      @$element.highcharts options

    # initialise the plugin
    @init()

    # make the plugin chainable
    @



  # default plugin settings
  $.graph::defaults =

  $.fn.graph = ( options ) ->
    @.each ->
      if $( @ ).data( 'graph' ) is undefined
        plugin = new $.graph( this, options )
        $( @).data( 'graph', plugin )

($ document).ready ->
  ($ '.chart-holder').graph()


