<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign Up Form by Colorlib</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="./asset/boostrap/fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="./asset/boostrap/css/style.css">
    </head>
    <body>
        <div class="main">
            <section class="sign-in">
                <div class="container">
                    <div class="signin-content">
                        <div class="signin-image">
                            <figure><img src="./asset/boostrap/images/signin-image.jpg" alt="sing up image"></figure>
                            <a href="register" class="signup-image-link">Create an account</a>
                            <a href="forgot" class="signup-image-link">Forgot password</a>
                        </div>

                        <div class="signin-form">
                            <h2 class="form-title">Sign up</h2>
                            <form action="login" method="POST" class="register-form" id="login-form">

                                <c:if test="${msg ne null}">
                                    <div class="alert alert-danger mb-3" role="alert">
                                        ${msg}
                                    </div>
                                </c:if>

                                <div class="form-group">
                                    <label for="username"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    <input type="text" name="username" id="username" placeholder="Username"/>
                                </div>
                                <div class="form-group">
                                    <label for="password"><i class="zmdi zmdi-lock"></i></label>
                                    <input type="password" name="password" id="password" placeholder="Password"/>
                                </div>

                                <div class="form-group">
                                    <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                    <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                                </div>
                                    
                                <div class="h-captcha" data-sitekey="de38ed28-e8a8-48a6-890f-640dd1bd2553"></div>
                                    
                                <div class="form-group form-button">
                                    <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                                </div>
                            </form>
                            <div class="social-login">
                                <span class="social-label">Or login with</span>
                                <ul class="socials">
                                    <li><a href="#"><i class="display-flex-center zmdi zmdi-facebook"></i></a></li>
                                    <li><a href="#"><i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
                                    <li><a href="#"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <script src="./asset/boostrap/vendor/jquery/jquery.min.js"></script>
        <script src="./asset/boostrap/js/main.js"></script>

        <!-- Add this in the head section of your HTML document -->
        <script src="https://hcaptcha.com/1/api.js" async defer></script>

    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>