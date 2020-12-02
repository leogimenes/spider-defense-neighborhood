		/** Gráfico de memória */
		var memoria = {
			y : 0,
		};

		var linha1 = {
			y : [ memoria.y ],
			mode : 'lines+markers',
			name : '% de uso Memoria RAM',
			type : 'line',
			line : {
				color : 'rgb(0, 0, 0)',
			}
		};
		var linha2 = {
			y : [ 0 ],
			mode : 'lines',
			line : {
				color : 'white',
			},
			name : ''
		}
		var layout = {
			title : 'Memoria RAM',
			xaxis : {
				range : [0, 30]
			},
			yaxis : {
				range: [0, 100]
			}
		};
		var datz2 = [ linha1, linha2 ];
		getDataM();
		Plotly.newPlot('grafico_memoria', datz2, layout);
		var cnt = 0;
		setInterval(function() {
			getDataM();
			Plotly.newPlot('grafico_memoria', datz2, layout);
			Plotly.extendTraces('grafico_memoria', {
				y : [ [ memoria.y ] ]
			}, [ 0 ]);
			cnt++;
			if (cnt > 30) {
				Plotly.relayout('grafico_memoria', {
					xaxis : {
						range : [ cnt - 30, cnt ]
					}
				});
			}
		}, 1000);

		function getDataM() {
			$.getJSON("api/memoria?hostName=" + hostName, function(data) {
				memoria.y = data;
			});
		}
		
		/** Gráfico de Disco */
		
		var disco = {
			disco1Livre : 1,
			disco1Ocupado : 1,
			disco2Livre : 1,
			disco2Ocupado : 1,
			disco3Livre : 1,
			disco3Ocupado : 1,
			disco4Livre : 1,
			disco4Ocupado : 1,
			disco5Livre : 1,
			disco5Ocupado : 1,
			disco6Livre : 1,
			disco6Ocupado : 1			
		};
		
		

		let datz = [ {
			values : [ disco.disco1Livre, disco.disco1Ocupado],
			labels : [ 'Disco', 'Disco' ],
			type : 'pie',
			textinfo : "percent",
			hoverinfo : 'label+value',
			marker : {
				colors : [ '2ED069', 'D02E4E']
			},
		  	domain: {
			    row: 0,
			    column: 0
			},
		},{
			values : [ disco.disco2Livre, disco.disco2Ocupado],
			labels : [ 'Disco', 'Disco' ],
			type : 'pie',
			textinfo : "percent",
			hoverinfo : 'label+value',
			marker : {
				colors : ['AB00D5', 'C6F700']
			},
		  	domain: {
			    row: 0,
			    column: 1
			},
		},{
			values : [ disco.disco3Livre, disco.disco3Ocupado],
			labels : [ 'Disco', 'Disco' ],
			type : 'pie',
			textinfo : "percent",
			hoverinfo : 'label+value',
			marker : {
				colors : [ '5381EC', 'F9B836']
			},
		  	domain: {
			    row: 0,
			    column: 2
			},
		},{
			values : [ disco.disco4Livre, disco.disco4Ocupado],
			labels : [ 'Disco', 'Disco' ],
			type : 'pie',
			textinfo : "percent",
			hoverinfo : 'label+value',
			marker : {
				colors : [ 'FFE280', 'FBFF69']
			},
		  	domain: {
			    row: 1,
			    column: 0
			},
		},{
			values : [ disco.disco5Livre, disco.disco5Ocupado],
			labels : [ 'Disco', 'Disco' ],
			type : 'pie',
			textinfo : "percent",
			hoverinfo : 'label+value',
			marker : {
				colors : ['71ECB3', 'F7A757']
			},
		  	domain: {
			    row: 1,
			    column: 1
			},
		},{
			values : [ disco.disco6Livre, disco.disco6Ocupado ],
			labels : [ 'Disco', 'Disco' ],
			type : 'pie',
			textinfo : "percent",
			hoverinfo : 'label+value',
			marker : {
				colors : [ '69FA64', '3ABF47']
			},
		  	domain: {
			    row: 1,
			    column: 2
			},
		},
		
		];
		
		var layoutDisco = {
			title : 'Disco',
			grid: {rows: 2, columns: 3}
		};
		
		getDataD();
		
		setInterval(function() {
			getDataD();
			
		},5000);

		function getDataD() {

			$.getJSON("api/disco?hostName=" + hostName, function(data) {
				for(let diskindex in data){
					datz[diskindex].values = [data[diskindex].discoLivre, data[diskindex].discoUsado];
					datz[diskindex].labels = ["Livre: " + data[diskindex].partition , "Em uso: " + data[diskindex].partition];
				}
				
				Plotly.newPlot('grafico_disco', datz, layoutDisco);
			});
		}
		
		/** Gráfico de Processamento */
		
		var processador = {
			y : 0,
		}
		
		var config = {reponsive: true};

		var linha1 = {
			y : [ processador.y ],
			mode : 'lines+markers',
			name : '% uso da CPU',
			type : 'line'
		}
		var linha2 = {
			y : [ 0 ],
			mode : 'lines',
			line : {
				color : 'white',
			},
			name : ''
		}
		var layoutProc = {
			title : 'CPU',
			xaxis : {
				range : [0, 30]
			},
			yaxis : {
				range : [0, 100]
			}
		}
		var datzProc = [ linha1, linha2 ];
		getDataP();
		Plotly.newPlot('grafico_cpu', datzProc, layoutProc);
		var cnt3 = 0;
		setInterval(function() {
			getDataP();
			Plotly.newPlot('grafico_cpu', datzProc, layoutProc);
			Plotly.extendTraces('grafico_cpu', {
				y : [ [ processador.y ] ]
			}, [ 0 ]);
			cnt3++;
			if (cnt3 > 30) {
				Plotly.relayout('grafico_cpu', {
					xaxis : {
						range : [ cnt3 - 30, cnt3 ]
					}
				});
			}
		}, 1000);

		function getDataP() {
			$.getJSON("api/processador?hostName=" + hostName, function(data) {
				processador.y = data;
			});
		}
		
		/** Gráfico de Rede */
		
		var down = {
			bufferDown: -1,
			y : 0,
		}
		
		var up = {
			bufferUp: -1,
			y : 0
		}

		var linha1 = {
			y : [ down.y ],
			mode : 'lines+markers',
			name : 'Download(bps)',
			type : 'line'
		}
		var linha2 = {
			y : [ up.y ],
			mode : 'lines+markers',
			name : 'Upload(bps)',
			type : 'line'
		}
		var layoutRede = {
			title : 'Taxa de tranferência',
			xaxis : {
				range : [0, 30]
			},
			yaxis : {
				constrain : "range"
			}
		}
		var datzR = [ linha1, linha2 ];
		getDataR();
		Plotly.newPlot('grafico_rede', datzR, layoutRede);
		var cnt4 = 0;
		setInterval(function() {
			getDataR();
			Plotly.newPlot('grafico_rede', datzR, layoutRede);
			Plotly.extendTraces('grafico_rede', {
				y : [ [ down.y ], [ up.y ] ]
			}, [ 0, 1 ]);
			cnt4++;
			if (cnt4 > 30) {
				Plotly.relayout('grafico_rede', {
					xaxis : {
						range : [ cnt4 - 30, cnt4 ]
					}
				});
			}
		}, 3000);

		function getDataR() {
			$.getJSON("api/rede?hostName=" + hostName, function(data) {
				if(down.bufferDown == -1){
					down.bufferDown = data.download;
					down.y = 0;
				} else {
					down.y = data.download - down.bufferDown;
					if(down.y < 0){
						down.y=0;
					}
					down.bufferDown = data.download;
				}
				if(up.bufferUp == -1){
					up.bufferUp = data.upload;
					up.y = 0;
				} else {
					up.y = data.upload - up.bufferUp;
					if(up.y < 0){
						up.y=0;
					}
					up.bufferUp = data.upload;
				}
			});
		}