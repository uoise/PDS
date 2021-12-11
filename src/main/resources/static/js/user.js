let index = {
    init: function () {
        $("#btn-sign-up").on("click", () => {
            if (this.valid()) {
                this.signup();
            }
        });
    },
    valid: function () {
        let formData = {
            email: $("#email").val(),
            username: $("#username").val(),
            password: $("#password").val()
        };
        console.log(formData);
        if (formData.email == "") {
            alert("이메일을 입력하세요.");
            document.getElementById("email").focus();
            return false;
        }
        if (formData.username == "") {
            alert("이름을 입력하세요.");
            document.getElementById("username").focus();
            return false;
        }
        if (formData.password == "") {
            alert("비밀번호를 입력하세요.");
            document.getElementById("password").focus();
            return false;
        }
        return true;
    },
    signup: function () {
        let formData = {
            email: $("#email").val(),
            username: $("#username").val(),
            password: $("#password").val()
        };
        $.ajax({
            type: "POST",
            url: "/auth/joinProc",
            data: JSON.stringify(formData),
            contentType: "application/json; charset=utf8",
            dataType: "json"
        }).done(function () {
            alert("회원가입 완료");
            location.href = "/";
        }).fail(function (error) {
            alert(error.responseText);
        });
    },
}

index.init();