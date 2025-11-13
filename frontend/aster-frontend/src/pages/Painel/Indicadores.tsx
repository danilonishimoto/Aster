import { useParams } from "react-router-dom";
import ProfileMenu from "../../components/ProfileMenu";

export default function Indicadores() {
    const params = useParams()

    return (
        <section className="w-full h-full flex flex-col items-center justify-start gap-6">
            <div className="w-full flex flex-row items-center justify-end">
                <ProfileMenu />
            </div>
            <h1>Indicadores Page - {params.view} ({params.user})</h1>
        </section>
    );
}