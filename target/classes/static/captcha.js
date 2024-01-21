function generateCaptcha() {
            const captchaContainer = document.getElementById('captcaid');
            const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
            let captcha = '';
            for (let i = 0; i < 5; i++) {
                const randomIndex = Math.floor(Math.random() * characters.length);
                captcha += characters.charAt(randomIndex);
            }
            captchaContainer.textContent = captcha;
            return captcha;
            
        }
 // Validate the entered CAPTCHA
        function validateCaptcha() {
            const enteredValue = document.getElementById('exampleInputPassword11').value;
            const captchaText = document.getElementById('captchaContainer').textContent;
            
            if (enteredValue === captchaText) {
                alert('CAPTCHA is correct. You are human!');
            } else {
                alert('CAPTCHA is incorrect. Please try again.');
                generateCaptcha(); // Regenerate CAPTCHA on failure
            }
        }

        // Initial CAPTCHA generation
        generateCaptcha();