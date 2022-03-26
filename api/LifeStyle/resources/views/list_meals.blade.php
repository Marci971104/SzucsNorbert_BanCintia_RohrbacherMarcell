<!-- @extends("layouts.master")

@section("content")

<div class="container">
    <div class="row">
        <div class="col-4">
            <form action="">
                <!-- <select name="color" id="">
                    <option selected>Szín</option>
                    <option>kék</option>
                    <option>sárga</option>
                    <option>piros</option>
                </select> -->
                <!-- <button class="btn btn-outline-info" type="submit">Keresés</button> -->
            </form>
        </div>

        <div class="col-4">
            <a href="/datas">Saját adatok</a>
            <a href="/BMI">BMI</a>
            <a href="/calorieIntake">Ajánlott kalóriabevitel</a>
        </div>

        <div class="col-4">
            <a href="/register">Regisztráció</a>
            <a href="/login">Bejelentkezés</a>
            <a href="/logout">Kijelentkezés</a>
        </div>
    </div>
        <div class="row">
            <div class="col-8">
                <table class="table table-stripped">
                    <thead>
                        <th scope="col">Id</th>
                        <th scope="col">Név</th>
                        <th scope="col">Kalória érték</th>
                        <th scope="col">Zsír</th>
                        <th scope="col">Fehérje</th>
                        <th scope="col">Szénhidrát</th>
                        <th scope="col">Só</th>
                    </thead>
                    <tbody>
                        @foreach($meals as $meal)
                            <tr>
                                <td>{{$meal->id}}</td>
                                <td>{{$meal->name}}</td>
                                <td>{{$meal->calorievalue}}</td>
                                <td>{{$meal->fat}}</td>
                                <td>{{$meal->protein}}</td>
                                <td>{{$meal->carbonhydrate}}</td>
                                <td>{{$meal->salt}}</td>
                                <td>
                                    <a class="btn btn-outline-primary btn-sm" href="/edit-meal/{{$meal->id}}">Szerkesztés</a>
                                    <a class="btn btn-outline-primary btn-sm" href="/delete-meal/{{$meal->id}}">Törlés</a>
                                </td>
                            </tr>
                        @endforeach 
                    </tbody>
                </table>
            </div>
            <div class="col-2">
                <a class="btn btn-outline-primary" href="/new-meal">Új étel</a>
            </div>
        </div>
</div>

@endsection -->