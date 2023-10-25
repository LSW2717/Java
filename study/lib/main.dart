import 'package:flutter/material.dart';
import 'package:study/common/component/custom_text_from_field.dart';

void main() {
  runApp(_App());
}

class _App extends StatelessWidget {
  //상속을 받았고 아래것은 생성자다
  _App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        backgroundColor: Colors.white,
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            CustomTextFromField(
              hintText: '이메일을 입력해주세요.',
              onChanged: (String value) {},
            ),
            SizedBox(height: 20),
            CustomTextFromField(
              hintText: '비밀번호를 입력해주세요.',
              onChanged: (String value) {},
              obscureText: true,
            ),
          ],
        ),
      ),
    );
  }
}
