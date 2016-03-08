<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        
        <!-- Title -->
        <title>QTS-Live</title>
        
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta charset="UTF-8">
        <meta name="description" content="Modern Landing Page" />
        <meta name="keywords" content="landing" />
        <meta name="author" content="Steelcoders" />
        
        <!-- Styles -->
		<!--<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'> -->
		<link href="assets/css/font-google-open-sans-400-300-600.css" rel="stylesheet" type="text/css">
		<!--<link href='http://fonts.googleapis.com/css?family=Raleway:500,400,300' rel='stylesheet' type='text/css'> -->
        <link href='assets/css/font-google-raleway-500-400-300.css' rel='stylesheet' type='text/css'>        
        <link href="assets-inicio/plugins/pace-master/themes/blue/pace-theme-flash.css" rel="stylesheet"/>
        <link href="assets-inicio/plugins/uniform/css/uniform.default.min.css" rel="stylesheet"/>
        <link href="assets-inicio/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets-inicio/plugins/fontawesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="assets-inicio/plugins/animate/animate.css" rel="stylesheet" type="text/css">
        <link href="assets-inicio/plugins/tabstylesinspiration/css/tabs.css" rel="stylesheet" type="text/css">
        <link href="assets-inicio/plugins/tabstylesinspiration/css/tabstyles.css" rel="stylesheet" type="text/css">	
        <link href="assets-inicio/plugins/pricing-tables/css/style.css" rel="stylesheet" type="text/css">
        <link href="assets-inicio/css/landing.css" rel="stylesheet" type="text/css"/>
        
        <script src="assets/plugins/pricing-tables/js/modernizr.js"></script>
        
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        
    </head>
    <body data-spy="scroll" data-target="#header">
        <nav id="header" class="navbar navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="fa fa-bars"></span>
                    </button>
                    <a class="navbar-brand" href="#">QTS-Live</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li><a href="#home">Início</a></li>
                        <li><a href="#features">Destaques</a></li>
                        <li><a href="#pricing">Planos</a></li>
                        <li><a href="#contact">Contato</a></li>                        
                    </ul>
                </div>
            </div>
        </nav>
        
        <div class="home" id="home">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="home-text col-md-8">                    	
                        <h1 class="wow fadeInDown" data-wow-delay="1.5s" data-wow-duration="1.5s" data-wow-offset="10">QTS-Live</h1>
                        <p class="lead wow fadeInDown" data-wow-delay="2s" data-wow-duration="1.5s" data-wow-offset="10"><span class="glyphicon glyphicon-cloud" aria-hidden="true"></span><br><s:text name="global.slogan" /><br></p>
                        <a href="<s:url action='login'/>" target="_blank" class="btn btn-default btn-rounded btn-lg wow fadeInUp" data-wow-delay="2.5s" data-wow-duration="1.5s" data-wow-offset="10">Login</a>
                        <a href="#features" id="botao-conhecer" target="_blank" class="btn btn-success btn-rounded btn-lg wow fadeInUp" data-wow-delay="2.5s" data-wow-duration="1.5s" data-wow-offset="10"><s:text name="global.conhecer" /></a>
                        <br/><br/>
                        <div class="wow wow fadeInUp" data-wow-delay="3s" data-wow-duration="1.5s" data-wow-offset="10">                        	
                            <form id="pt-br-form" action="bem-vindo" method="POST">
								<input type="hidden" name="request_locale" value="pt" />
								<input type="hidden" name="idioma" value="pt" />
								<input type="hidden" name="pais" value="BR" />
							</form>
							<form id="en-form" action="welcome" method="POST">
								<input type="hidden" name="request_locale" value="en" />
								<input type="hidden" name="idioma" value="en" />
								<input type="hidden" name="pais" value="US" />
							</form>								
							<form id="es-form" action="bienvenido" method="POST">
								<input type="hidden" name="request_locale" value="es" />
								<input type="hidden" name="idioma" value="es" />
								<input type="hidden" name="pais" value="ES" />
							</form>						
							<a href="#"><img id="pt-br-img" src="assets/images/lang/pt-br.png" width="28px" height="20px" alt=""></a>									
							<a href="#"><img id="en-img" src="assets/images/lang/en.png" width="28px" height="20px" alt=""></a>
							<a href="#"><img id="es-img" src="assets/images/lang/es.png" width="28px" height="20px" alt=""></a>
	               		</div>
                    </div>
                    <div class="scroller">
                        <div class="mouse"><div class="wheel"></div></div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container" id="features">
            <div class="row features-list">
                <div class="col-sm-4 wow fadeInLeft" data-wow-duration="1.5s" data-wow-offset="10" data-wow-delay="0.5s">
                    <div class="feature-icon">
                        <i class="fa fa-laptop"></i>
                    </div>
                    <h2>Site responsivo</h2>
                    <p>Acesse através de seu celular ou tablet.</p>
<!--                     <p><a class="btn btn-link" href="#" role="button">View details &raquo;</a></p> -->
                </div>
                <div class="col-sm-4 wow fadeInLeft" data-wow-duration="1.5s" data-wow-offset="10" data-wow-delay="0.7s">
                    <div class="feature-icon">
                        <i class="fa fa-lightbulb-o"></i>
                    </div>
                    <h2>Design inteligente</h2>
                    <p>Desenvolvido para facilitar o cadastro de suas atividades.</p>
<!--                     <p><a class="btn btn-link" href="#" role="button">View details &raquo;</a></p> -->
                </div>
                <div class="col-sm-4 wow fadeInLeft" data-wow-duration="1.5s" data-wow-offset="10" data-wow-delay="0.9s">
                    <div class="feature-icon">
                        <i class="fa fa-support"></i>
                    </div>
                    <h2>Suporte 24/7</h2>
                    <p>Atendimento 24h por dia 7 dias por semana</p>
<!--                     <p><a class="btn btn-link" href="#" role="button">View details &raquo;</a></p> -->
                </div>
            </div>
        </div>
        <section id="section-1">
            <div class="container">
                <div class="row">
                    <div class="col-sm-4 wow fadeInLeft" data-wow-delay="0.5s" data-wow-duration="1.5s" data-wow-offset="10">
                        <img src="assets-inicio/images/iphone.png" class="iphone-img" alt="">
                    </div>
                    <div class="col-sm-8 wow fadeInRight" data-wow-delay="0.5s" data-wow-duration="1.5s" data-wow-offset="10">
                        <h1>The Power You Need</h1>
                        <p>Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Donec elit libero, sodales nec, volutpat a, suscipit non, turpis. Nullam sagittis. Suspendisse pulvinar, augue ac venenatis condimentum, sem libero volutpat nibh, nec pellentesque velit pede quis nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Fusce id purus. Ut varius tincidunt libero.</p>
                        <ul class="list-unstyled features-list-2">
                            <li><i class="fa fa-diamond icon-state-success m-r-xs icon-md"></i>Unique design</li>
                            <li><i class="fa fa-check icon-state-success m-r-xs icon-md"></i>Everything you need</li>
                            <li><i class="fa fa-cogs icon-state-success m-r-xs icon-md"></i>Tons of features</li>
                            <li><i class="fa fa-cloud icon-state-success m-r-xs icon-md"></i>Easy to use &amp; customize</li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <section id="section-2">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 wow fadeInLeft" data-wow-delay="0.5s" data-wow-duration="1.5s" data-wow-offset="10">
                        <section>
                            <div class="tabs tabs-style-linebox">
                                <nav>
                                    <ul>
                                        <li class="tab-current"><a href=""><span>Responsive</span></a></li>
                                        <li class=""><a href=""><span>Browsers</span></a></li>
                                        <li class=""><a href=""><span>Bootstrap</span></a></li>
                                        <li class=""><a href=""><span>Icons</span></a></li>
                                        <li class=""><a href=""><span>Documentation</span></a></li>
                                    </ul>
                                </nav>
                                <div class="content-wrap">
                                    <section class="content-current">
                                        <h1>Responsive Design</h1>
                                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.<br>Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus.</p></section>
                                    <section><p>
                                        <h1>Cross-browser Compatible</h1>
                                        <p>Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus.<br>Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna.</p></section>
                                    <section><p>
                                        <h1>Built With Bootstrap 3.3.4</h1>
                                        <p>Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada. Praesent congue erat at massa. Sed cursus turpis vitae tortor. Donec posuere vulputate arcu. Phasellus accumsan cursus velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed aliquam, nisi quis porttitor congue, elit erat euismod orci, ac placerat dolor lectus quis orci. Phasellus consectetuer vestibulum elit. Aenean tellus metus, bibendum sed, posuere ac, mattis non, nunc.</p></section>
                                    <section><p>
                                        <h1>+1100 Icons Included</h1>
                                        <p>Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Donec elit libero, sodales nec, volutpat a, suscipit non, turpis. Nullam sagittis.<br>Suspendisse pulvinar, augue ac venenatis condimentum, sem libero volutpat nibh, nec pellentesque velit pede quis nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Fusce id purus. Ut varius tincidunt libero. Phasellus dolor. Maecenas vestibulum mollis diam.</p></section>
                                    <section><p>
                                        <h1>Well Documented</h1>
                                        <p>Morbi nec metus. Phasellus blandit leo ut odio. Maecenas ullamcorper, dui et placerat feugiat, eros pede varius nisi, condimentum viverra felis nunc et lorem. Sed magna purus, fermentum eu, tincidunt eu, varius ut, felis. In auctor lobortis lacus. Quisque libero metus, condimentum nec, tempor a, commodo mollis, magna. Vestibulum ullamcorper mauris at ligula. Fusce fermentum. Nullam cursus lacinia erat. Praesent blandit laoreet nibh.</p></section>
                                </div>
                            </div>
                        </section>
                    </div>
                    <div class="col-sm-4 wow fadeInRight" data-wow-delay="0.5s" data-wow-duration="1.5s" data-wow-offset="10">
                        <img src="assets-inicio/images/iphone2.png" class="iphone-img" alt="">
                    </div>
                </div>    
            </div>
        </section>
        <section id="section-3">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 wow fadeInUp" data-wow-delay="0.5s" data-wow-duration="1.5s" data-wow-offset="10">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner" role="listbox">
                                <div class="item active">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <p class="text-white">"Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Donec elit libero, sodales nec, volutpat a, suscipit non, turpis. Nullam sagittis. Suspendisse pulvinar, augue ac venenatis condimentum, sem libero volutpat nibh, nec pellentesque velit pede quis nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Fusce id purus. Ut varius tincidunt libero."</p>
                                            <span>- David, App Manager</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <p class="text-white">"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo."</p>
                                            <span>- Sandra, Director</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <p>"Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada. Praesent congue erat at massa. Sed cursus turpis vitae tortor. Donec posuere vulputate arcu. Phasellus accumsan cursus velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed aliquam, nisi quis porttitor congue, elit erat euismod orci, ac placerat dolor lectus quis orci. Phasellus consectetuer vestibulum elit."</p>
                                            <span>- Amily, UI Designer</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>    
            </div>
        </section>
        <div class="container" id="pricing">
            <div class="row">
                <div class="cd-pricing-container">
                    <div class="cd-pricing-switcher">
                        <p class="fieldset">
                            <input type="radio" class="no-uniform" name="duration-1" value="monthly" id="monthly-1" checked>
                            <label for="monthly-1">Monthly</label>
                            <input type="radio" class="no-uniform" name="duration-1" value="yearly" id="yearly-1">
                            <label for="yearly-1">Yearly</label>
                            <span class="cd-switch"></span>
                        </p>
                    </div>
                    <ul class="cd-pricing-list cd-bounce-invert">
                        <li>
                            <ul class="cd-pricing-wrapper">
                                <li data-type="monthly" class="is-visible">
                                    <header class="cd-pricing-header">
                                        <h2>Basic</h2>
                                        <div class="cd-price">
                                            <span class="cd-currency">$</span>
                                            <span class="cd-value">30</span>
                                            <span class="cd-duration">mo</span>
                                        </div>
                                    </header>
                                    <div class="cd-pricing-body">
                                        <ul class="cd-pricing-features">
                                            <li><em>256MB</em> Memory</li>
                                            <li><em>1</em> User</li>
                                            <li><em>1</em> Website</li>
                                            <li><em>1</em> Domain</li>
                                            <li><em>Unlimited</em> Bandwidth</li>
                                            <li><em>24/7</em> Support</li>
                                        </ul>
                                    </div>
                                    <footer class="cd-pricing-footer">
                                        <a class="cd-select" href="#">Select</a>
                                    </footer>
                                </li>
                                <li data-type="yearly" class="is-hidden">
                                    <header class="cd-pricing-header">
                                        <h2>Basic</h2>
                                        <div class="cd-price">
                                            <span class="cd-currency">$</span>
                                            <span class="cd-value">320</span>
                                            <span class="cd-duration">yr</span>
                                        </div>
                                    </header>
                                    <div class="cd-pricing-body">
                                        <ul class="cd-pricing-features">
                                            <li><em>256MB</em> Memory</li>
                                            <li><em>1</em> User</li>
                                            <li><em>1</em> Website</li>
                                            <li><em>1</em> Domain</li>
                                            <li><em>Unlimited</em> Bandwidth</li>
                                            <li><em>24/7</em> Support</li>
                                        </ul>
                                    </div>
                                    <footer class="cd-pricing-footer">
                                        <a class="cd-select" href="#">Select</a>
                                    </footer>
                                </li>
                            </ul>
                        </li>
                        <li class="cd-popular">
                            <ul class="cd-pricing-wrapper">
                                <li data-type="monthly" class="is-visible">
                                    <header class="cd-pricing-header">
                                        <h2>Popular</h2>
                                        <div class="cd-price">
                                            <span class="cd-currency">$</span>
                                            <span class="cd-value">60</span>
                                            <span class="cd-duration">mo</span>
                                        </div>
                                    </header>
                                    <div class="cd-pricing-body">
                                        <ul class="cd-pricing-features">
                                            <li><em>512MB</em> Memory</li>
                                            <li><em>3</em> Users</li>
                                            <li><em>5</em> Websites</li>
                                            <li><em>7</em> Domains</li>
                                            <li><em>Unlimited</em> Bandwidth</li>
                                            <li><em>24/7</em> Support</li>
                                        </ul>
                                    </div>
                                    <footer class="cd-pricing-footer">
                                        <a class="cd-select" href="#">Select</a>
                                    </footer>
                                </li>
                                <li data-type="yearly" class="is-hidden">
                                    <header class="cd-pricing-header">
                                        <h2>Popular</h2>
                                        <div class="cd-price">
                                            <span class="cd-currency">$</span>
                                            <span class="cd-value">630</span>
                                            <span class="cd-duration">yr</span>
                                        </div>
                                    </header>
                                    <div class="cd-pricing-body">
                                        <ul class="cd-pricing-features">
                                            <li><em>512MB</em> Memory</li>
                                            <li><em>3</em> Users</li>
                                            <li><em>5</em> Websites</li>
                                            <li><em>7</em> Domains</li>
                                            <li><em>Unlimited</em> Bandwidth</li>
                                            <li><em>24/7</em> Support</li>
                                        </ul>
                                    </div>
                                    <footer class="cd-pricing-footer">
                                        <a class="cd-select" href="#">Select</a>
                                    </footer>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <ul class="cd-pricing-wrapper">
                                <li data-type="monthly" class="is-visible">
                                    <header class="cd-pricing-header">
                                        <h2>Premier</h2>
                                        <div class="cd-price">
                                            <span class="cd-currency">$</span>
                                            <span class="cd-value">90</span>
                                            <span class="cd-duration">mo</span>
                                        </div>
                                    </header>
                                    <div class="cd-pricing-body">
                                        <ul class="cd-pricing-features">
                                            <li><em>1024MB</em> Memory</li>
                                            <li><em>5</em> Users</li>
                                            <li><em>10</em> Websites</li>
                                            <li><em>10</em> Domains</li>
                                            <li><em>Unlimited</em> Bandwidth</li>
                                            <li><em>24/7</em> Support</li>
                                        </ul>
                                    </div>
                                    <footer class="cd-pricing-footer">
                                        <a class="cd-select" href="#">Selecionar</a>
                                    </footer>
                                </li>
                                <li data-type="yearly" class="is-hidden">
                                    <header class="cd-pricing-header">
                                        <h2>Premier</h2>
                                        <div class="cd-price">
                                            <span class="cd-currency">$</span>
                                            <span class="cd-value">950</span>
                                            <span class="cd-duration">yr</span>
                                        </div>
                                    </header>
                                    <div class="cd-pricing-body">
                                        <ul class="cd-pricing-features">
                                            <li><em>1024MB</em> Memory</li>
                                            <li><em>5</em> Users</li>
                                            <li><em>10</em> Websites</li>
                                            <li><em>10</em> Domains</li>
                                            <li><em>Unlimited</em> Bandwidth</li>
                                            <li><em>24/7</em> Support</li>
                                        </ul>
                                    </div>
                                    <footer class="cd-pricing-footer">
                                        <a class="cd-select" href="#">Selecionar</a>
                                    </footer>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="contact">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3 wow rotateInUpLeft" data-wow-duration="1.5s" data-wow-offset="10" data-wow-delay="0.5s">
                        <a href="#contact" class="btn btn-success btn-lg btn-rounded contact-button"><i class="fa fa-envelope-o"></i></a>
                        <h2>Entre em contato</h2>
                        <form class="m-t-md">
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control input-lg contact-name" placeholder="Nome">
                                    </div>
                                    <div class="col-sm-6">      
                                        <input type="email" class="form-control input-lg" placeholder="E-mail">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control input-lg" placeholder="Assunto">
                            </div>
                            <div class="form-group">
                                <textarea class="form-control" rows="4=6" placeholder="Mensagem"></textarea>
                            </div>
                            <button type="submit" class="btn btn-default btn-lg">Enviar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <div class="container">
                <p class="text-center no-s">2015 &copy; QTS-Live.</p>
            </div>
        </footer>
        
        <!-- Javascripts -->
        <script src="assets-inicio/plugins/jquery/jquery-2.1.3.min.js"></script>
        <script src="assets-inicio/plugins/jquery-ui/jquery-ui.min.js"></script>
        <script src="assets-inicio/plugins/pace-master/pace.min.js"></script>
        <script src="assets-inicio/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets-inicio/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <script src="assets-inicio/plugins/uniform/jquery.uniform.min.js"></script>
        <script src="assets-inicio/plugins/wow/wow.min.js"></script>
        <script src="assets-inicio/plugins/tabstylesinspiration/js/cbpfwtabs.js"></script>
        <script src="assets-inicio/plugins/pricing-tables/js/main.js"></script>
        <script src="assets-inicio/js/landing.js"></script>
        
        <script type="text/javascript">
	        $(document).ready(function() {
	
				//Langs
				$("#pt-br-img").click(function(e) {
					//e.preventDefault();
					$("#pt-br-form").submit();
				});
				$("#en-img").click(function(e) {
					//e.preventDefault();
					$("#en-form").submit();
				});
				$("#es-img").click(function(e) {
					//e.preventDefault();
					$("#es-form").submit();
				});
				
				
	
			}); //fim ready
        </script>
        
    </body>
</html>