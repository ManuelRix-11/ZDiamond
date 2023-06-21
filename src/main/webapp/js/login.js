$(document).ready(function ()
{
    function isValidEmail(email)
    {
        let regex = /^\w+([.-]?\w+)@\w+([.-]?\w+)(.\w{2,3})+$/;
        return regex.test(email);
    }

    $("#login-form").submit(function (event) {
        let username = $("#username").val();
        let password = $("#password").val();
        let result = $("#result-login");

        if (isValidEmail(username) || username==="admin") {
            $.ajax({
                url: "login",

                type: "post",
                data:
                    {
                        username: username,
                        password: password
                    },
                success: function () {
                    window.location.reload();

                }
            });
        } else
            result.html("Login fallito");

        event.preventDefault();
    });
});