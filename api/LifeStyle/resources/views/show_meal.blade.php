@extends("layouts.master")

@section("content")

<div class="container">
        <div class="row">
            <div class="col-8">
                <table class="table table-stripped">
                    <thead>
                        <th scope="col">Id</th>
                        <th scope="col">Név</th>
                        <th scope="col">Kalóriaérték</th>
                        <th scope="col">Zsír</th>
                        <th scope="col">Fehérje</th>
                        <th scope="col">Szénhidrát</th>
                        <th scope="col">Só</th>
                    </thead>
                    <tbody>
                        {{--@foreach($meals as $meal)
                            <tr>
                                <td>{{$meal->id}}</td>
                                <td>{{$meal->name}}</td>
                                <td>{{$meal->calorievalue}}</td>
                                <td>{{$meal->fat}}</td>
                                <td>{{$meal->protein}}</td>
                                <td>{{$meal->carbonhydrate}}</td>
                                <td>{{$meal->salt}}</td>
                            </tr>
                        @endforeach --}}
                    </tbody>
                </table>
            </div>
            <div class="col-2">
                <a class="btn btn-outline-primary" href="/new-meal">Új étel</a>
            </div>
        </div>
</div>

@endsection